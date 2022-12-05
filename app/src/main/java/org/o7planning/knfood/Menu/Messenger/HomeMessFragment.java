package org.o7planning.knfood.Menu.Messenger;


import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import org.o7planning.knfood.Adapter.AllUserAdapter;
import org.o7planning.knfood.Adapter.MessengerAdapter;
import org.o7planning.knfood.AdapterListener;
import org.o7planning.knfood.Constants;
import org.o7planning.knfood.Model.Conversation;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.R;
import org.o7planning.knfood.base.BaseFragment;
import org.o7planning.knfood.viewmodel.HomeMessViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeMessFragment extends BaseFragment<HomeMessViewModel> {
    private AllUserAdapter allUsersAdapter;
    private MessengerAdapter messageAdapter;
    private EditText edtSearchUser;
    private RecyclerView rvAllUser,rvListMess;

    public HomeMessFragment() {
        // Required empty public constructor
    }

//    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
//            int position = viewHolder.getAdapterPosition();
//            Messenger mess = dsMess.get(position);
//            username=mess.getUsername();
//            Intent i = new Intent(v.getContext(),MessRoom.class);
//            startActivity(i);
//        }
//    };
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//     ViewGroup root =  (ViewGroup)inflater.inflate(R.layout.fragment_tin_nhan, container, false);
//     // list chat
//        rv_list_mess = root.findViewById(R.id.rcv_mess_list);
//        Messenger user = new Messenger("ac","Trần Hiếu","Xin chào! Tôi cần giúp đỡ...","Trực tuyến");
//        Messenger user2 = new Messenger("ac","Ngọc Anh","Xin chào! Tôi cần giúp đỡ...","Đang bận");
//        Messenger user3 = new Messenger("ac","Văn Hải","Xin chào! Tôi cần giúp đỡ...","Ngoại tuyến");
//        dsMess.add(user);   dsMess.add(user2);   dsMess.add(user3); dsMess.add(user2);   dsMess.add(user3);        dsMess.add(user);   dsMess.add(user2);   dsMess.add(user3); dsMess.add(user2);   dsMess.add(user3);
//        dsMess.add(user);   dsMess.add(user2);   dsMess.add(user3); dsMess.add(user2);   dsMess.add(user3);
//
//        MessengerAdapter adapter = new MessengerAdapter(dsMess);
//        rv_list_mess.setLayoutManager(new LinearLayoutManager(root.getContext()));
//        rv_list_mess.setAdapter(adapter);
//        adapter.setOnItemClickListener(onItemClickListener);
//        return root;
//    }

    @Override
    protected void initViews() {

        mModel.loadUser();
        rvAllUser = findViewById(R.id.rcv_all_user);
        rvListMess = findViewById(R.id.rcv_mess_list);
        edtSearchUser = findViewById(R.id.edt_search_user);
        //all users recycle view
        rvAllUser.setHasFixedSize(true);
        rvAllUser.setLayoutManager(new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false));
        allUsersAdapter = new AllUserAdapter(mModel.getUserArrayList());
        rvAllUser.setAdapter(allUsersAdapter);
        allUsersAdapter.setListener(new AdapterListener() {
            @Override
            public void onClick(User user) {
                gotoChatFragment(user);
            }
        });


        //recent user recycle view
        rvListMess.setHasFixedSize(true);
        rvListMess.setLayoutManager(new LinearLayoutManager(requireContext()));
        messageAdapter = new MessengerAdapter(mModel.getConversationArrayList());
        rvListMess.setAdapter(messageAdapter);
        messageAdapter.setListener(new AdapterListener() {
            @Override
            public void onClick(User user) {
                gotoChatFragment(user);
            }
        });

        edtSearchUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mModel.searchUser(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mModel.getUsers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                allUsersAdapter.notifyDataSetChanged();
                mModel.loadRecentConversation();
            }
        });

        mModel.getConversations().observe(this, new Observer<ArrayList<Conversation>>() {
            @Override
            public void onChanged(ArrayList<Conversation> conversations) {
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    private void gotoChatFragment(User user) {
        Intent i = new Intent(getContext(), RoomMessActivity.class);
        i.putExtra("user",user);
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        mModel.setStatus(Constants.ONLINE);
    }

    @Override
    public void onPause() {
        super.onPause();
        mModel.setStatus(Constants.OFFLINE);
    }


    @Override
    protected Class<HomeMessViewModel> getClassViewModel() {
        return HomeMessViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tin_nhan;
    }

}
