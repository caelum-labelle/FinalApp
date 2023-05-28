package com.example.finalapp;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalapp.Adapter.C_Adapter;
import com.example.finalapp.Adapter.FirebaseControl;
import com.example.finalapp.Adapter.P_Adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<HomeCryptoData> mList = new ArrayList<>();
    private P_Adapter adapter;
    Dialog myDialog;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortfolioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PortfolioFragment newInstance(String param1, String param2) {
        PortfolioFragment fragment = new PortfolioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_portfolio, container, false);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portfolio, container, false);
        recyclerView = view.findViewById(R.id.pRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new P_Adapter(mList);
        adapter.setOnItemClickListener(new P_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeCryptoData data) {
//                Intent intent = new Intent(getContext(), Cryptos.class);
//                startActivity(intent);
                myDialog = new Dialog(requireContext());
                ShowPopup(data.getCryptoname());


            }

        });

        recyclerView.setAdapter(adapter);
        addDataToList(1);

        // Set OnClickListener for the buttons
//        Button btnHot = view.findViewById(R.id.btnHot);
//        Button btnList = view.findViewById(R.id.btnList);
//        Button btnGain = view.findViewById(R.id.btnGain);

//        btnHot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addDataToList(1);
//            }
//        });
//
//        btnList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addDataToList(2);
//            }
//        });
//
//        btnGain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addDataToList(3);
//            }
//        });

        return view;
    }

    private void ShowPopup(String name) {
        TextView txtclose;
        Button btnRemove;

        myDialog.setContentView(R.layout.deletepop_up);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        btnRemove = (Button) myDialog.findViewById(R.id.btnRemove);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://final-app-19fb2-default-rtdb.firebaseio.com/");
                DatabaseReference cryptoRef = database.getReference("Crypto");
                DatabaseReference Crypto = cryptoRef.child(name);
                Crypto.child("type").setValue(1);

                myDialog.dismiss();
            }
        });
    }

    FirebaseControl fire = new FirebaseControl();
    private void addDataToList(int ftype){
        mList.clear();
//        mList.add(new HomeCryptoData("Name", "Price", "Change"));
//        fire.AddCrypto(new HomeCryptoData("Btc", "5454", "231",3));
//        fire.AddCrypto(new HomeCryptoData("Tnc", "5454", "231",2));
//        fire.AddCrypto(new HomeCryptoData("Flx", "5454", "231",1));
//        fire.AddCrypto(new HomeCryptoData("Ctd", "4354", "441",2));
//        fire.AddCrypto(new HomeCryptoData("Dts", "45432", "411",3));
//        mList.add(new HomeCryptoData("Mich", "None", "Sample"));
        DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://final-app-19fb2-default-rtdb.firebaseio.com/")
                .getReference()
                .child("Crypto");

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String title = snapshot.getKey();
                    String cryptoName = snapshot.child("cryptoname").getValue(String.class);
                    String lastPrice = snapshot.child("lastprice").getValue(String.class);
                    String changes = snapshot.child("changes").getValue(String.class);
                    int type = snapshot.child("type").getValue(Integer.class);

                    if(type==0){
                        HomeCryptoData data = new HomeCryptoData(cryptoName, lastPrice, changes,type);
                        mList.add(data);
                    }
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Crypto", "Error retrieving data: " + databaseError.getMessage());
            }
        });
    }
}