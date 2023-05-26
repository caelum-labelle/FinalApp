package com.example.finalapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.finalapp.Adapter.C_Adapter;
import com.example.finalapp.Adapter.CommentAdapter;
import com.example.finalapp.Adapter.FirebaseControl;
import com.example.finalapp.Domain.RandomName;
import com.example.finalapp.Domain.UserComment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SocialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SocialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SocialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SocialFragment newInstance(String param1, String param2) {
        SocialFragment fragment = new SocialFragment();
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
    private RecyclerView recyclerView;
    private ArrayList<UserComment> mList = new ArrayList<>();
    private CommentAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social, container, false);
        ImageButton btnLike = (ImageButton) view.findViewById(R.id.btnHeart);
        ImageButton btnSend = (ImageButton) view.findViewById(R.id.btnSend);
        FirebaseControl fire = new FirebaseControl();
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnLike.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.blackh).getConstantState())) {
                    // The ImageButton has the desired image resource
                    btnLike.setImageResource(R.drawable.redh);
                    // Perform your desired actions here
                } else {
                    // The ImageButton does not have the desired image resource
                    btnLike.setImageResource(R.drawable.blackh);
                }
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String com = ((EditText) view.findViewById(R.id.txtComment)).getText().toString();
                RandomName name = new RandomName();
                UserComment uComment = new UserComment(name.generateRandomSentence(), com);
                fire.AddComment(uComment);
            }
        });
        recyclerView = view.findViewById(R.id.commentsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new CommentAdapter(mList);
        adapter.setOnItemClickListener(new CommentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserComment data) {

            }

        });
        recyclerView.setAdapter(adapter);
        addDataToList();
        return view;
    }
    private void addDataToList(){
        mList.clear();
        FirebaseControl fire = new FirebaseControl();
//        mList.add(new HomeCryptoData("Name", "Price", "Change"));
//        fire.AddComment(new UserComment("John","Wow this is amazing!!!"));
//        fire.AddComment(new UserComment("Derick","This is good news!!!"));
//        fire.AddCrypto(new HomeCryptoData("Tnc", "5454", "231",2));
//        fire.AddCrypto(new HomeCryptoData("Flx", "5454", "231",1));
//        fire.AddCrypto(new HomeCryptoData("Ctd", "4354", "441",2));
//        fire.AddCrypto(new HomeCryptoData("Dts", "45432", "411",3));
//        mList.add(new HomeCryptoData("Mich", "None", "Sample"));
        DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://final-app-19fb2-default-rtdb.firebaseio.com/")
                .getReference()
                .child("Comments");

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String title = snapshot.getKey();
                    String username = snapshot.child("username").getValue(String.class);
                    String comment = snapshot.child("comment").getValue(String.class);

                    UserComment data = new UserComment(username,comment);
                    mList.add(data);
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