package com.example.finalapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalapp.Adapter.C_Adapter;
import com.google.android.play.core.integrity.v;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ArrayList<HomeCryptoData> mList = new ArrayList<>();
    private C_Adapter adapter;
    Dialog myDialog;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment231.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.homeRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new C_Adapter(mList);
        adapter.setOnItemClickListener(new C_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeCryptoData data) {
//                Intent intent = new Intent(getContext(), Cryptos.class);
//                startActivity(intent);
                myDialog = new Dialog(requireContext());

                //TextView cname = view.findViewById(R.id.txtCName);
                ShowPopup(data.getCryptoname());
                //ShowPopup(cname.getText().toString());
                //ShowPopup(cname.getText().toString());


            }

        });

        recyclerView.setAdapter(adapter);
        addDataToList(1);

        // Set OnClickListener for the buttons
        Button btnHot = view.findViewById(R.id.btnHot);
        Button btnList = view.findViewById(R.id.btnList);
        Button btnGain = view.findViewById(R.id.btnGain);

        btnHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToList(1);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToList(2);
            }
        });

        btnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToList(3);
            }
        });

        return view;
    }

    private void ShowPopup(String name) {
        TextView txtclose;
        Button btnConfirm;

        myDialog.setContentView(R.layout.pop_up);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        btnConfirm = (Button) myDialog.findViewById(R.id.btnConfirm);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://final-app-19fb2-default-rtdb.firebaseio.com/");
                DatabaseReference cryptoRef = database.getReference("Crypto");
                DatabaseReference Crypto = cryptoRef.child(name);
                Crypto.child("type").setValue(0);

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

                    if(type==ftype){
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