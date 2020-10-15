package com.tuki.presentation.main.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.tuki.R;
import com.tuki.data.entity.Challenge;
import com.tuki.data.entity.Contact;
import com.tuki.data.entity.Route;
import com.tuki.presentation.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements OnContactItemListener, OnRouteItemListener, OnChallengeItemListener {

    @BindView(R.id.rv_my_contacts)
    RecyclerView rvMyContacts;
    @BindView(R.id.rv_routes)
    RecyclerView rvRoutes;
    @BindView(R.id.rv_challenges_by_route)
    RecyclerView rvChallengesByRoute;

    @BindView(R.id.btn_info)
    FrameLayout btnInfo;

    private ContactAdapter contactAdapter;
    private LastRoutesAdapter lastRoutesAdapter;
    private ChallengesByRouteAdapter challengesByRouteAdapter;
    private SnapHelper snapHelperContacts;
    private SnapHelper snapHelperLastRoutes;
    private List<Contact> contacts = new ArrayList<>();
    private List<Route> lastRoutes = new ArrayList<>();
    private List<Route> allRoutes = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        snapHelperContacts = new GravitySnapHelper(Gravity.START);
        snapHelperLastRoutes = new GravitySnapHelper(Gravity.START);

        contacts.add(new Contact("https://randomuser.me/api/portraits/women/29.jpg", "Roxana", 1));
        contacts.add(new Contact("https://randomuser.me/api/portraits/men/42.jpg", "Tomas", 0));
        contacts.add(new Contact("https://randomuser.me/api/portraits/women/28.jpg", "Giseel", 1));
        contacts.add(new Contact("https://randomuser.me/api/portraits/men/81.jpg", "Sergio", 0));
        contacts.add(new Contact("https://randomuser.me/api/portraits/women/11.jpg", "Claudia", 1));
        contacts.add(new Contact("https://randomuser.me/api/portraits/men/90.jpg", "Takeshi", 0));
        contacts.add(new Contact("https://randomuser.me/api/portraits/women/45.jpg", "Lizeth", 1));
        contacts.add(new Contact("https://randomuser.me/api/portraits/men/2.jpg", "Anderson", 0));

        lastRoutes.add(new Route("https://locuraviajes.com/wp-content/uploads/2017/06/mejores-paisajes-mundo-bora-bora-pixabay-600x400.jpg", "Bora Bora"));
        lastRoutes.add(new Route("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdiFDRNjbNS3JC5RvTe7t4pKcebk_aWTgZu46XjzLNgWC-TB8Z", "Indonesia"));
        lastRoutes.add(new Route("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg", "Chichen Itza"));

        List<Challenge> challenges = new ArrayList<>();
        Challenge challenge1 = new Challenge();
        Challenge challenge2 = new Challenge();
        Challenge challenge3 = new Challenge();

        challenge1.setName("Primer reto");
        challenge1.setPhotoUrl("https://locuraviajes.com/wp-content/uploads/2017/06/mejores-paisajes-mundo-bora-bora-pixabay-600x400.jpg");
        challenge2.setName("Segundo reto");
        challenge2.setPhotoUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdiFDRNjbNS3JC5RvTe7t4pKcebk_aWTgZu46XjzLNgWC-TB8Z");
        challenge3.setName("Tercer reto");
        challenge3.setPhotoUrl("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg");

        challenges.add(challenge1);
        challenges.add(challenge2);
        challenges.add(challenge3);


        Route route1 = new Route("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg", "Ruta numero 1");
        route1.setChallenges(challenges);

        Route route2 = new Route("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg", "Ruta numero 2");
        route2.setChallenges(challenges);

        Route route3 = new Route("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg", "Ruta numero 3");
        route3.setChallenges(challenges);

        Route route4 = new Route("https://www.paisajesbonitos.org/wp-content/uploads/2016/01/Chichen-Itza-piramide-Templo-de-Kukulc%C3%A1n-mexico-859x447.jpg", "Ruta numero 4");
        route4.setChallenges(challenges);

        allRoutes.add(route1);
        allRoutes.add(route2);
        allRoutes.add(route3);
        allRoutes.add(route4);

        contactAdapter = new ContactAdapter(contacts, this);
        lastRoutesAdapter = new LastRoutesAdapter(lastRoutes, this);
        challengesByRouteAdapter = new ChallengesByRouteAdapter(allRoutes, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        rvMyContacts.setAdapter(contactAdapter);
        rvMyContacts.setHasFixedSize(true);
        rvRoutes.setAdapter(lastRoutesAdapter);
        rvRoutes.setHasFixedSize(true);
        rvChallengesByRoute.setAdapter(challengesByRouteAdapter);
        rvChallengesByRoute.setHasFixedSize(true);

        snapHelperContacts.attachToRecyclerView(rvMyContacts);
        snapHelperLastRoutes.attachToRecyclerView(rvRoutes);

        ViewUtils.showContextLabel(getActivity(), btnInfo, R.string.info);

        return view;
    }


    @Override
    public void onClick(Contact contact, View view, int adapterPosition) {
        Bundle bundle = new Bundle();
        bundle.putInt("typeContact", contact.getType());
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileOtherFragment, bundle);



        /*Fragment fragment = new ProfileOtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("transitionName", "transition");
        fragment.setArguments(bundle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementReturnTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.default_transition));
            setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.no_transition));

            fragment.setSharedElementEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.default_transition));
            fragment.setEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.no_transition));
            view.setTransitionName("transition");
        }

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_main, fragment, "OTHER_PROFILE");
        fragmentTransaction.addToBackStack("OTHER_PROFILE");
        fragmentTransaction.addSharedElement(view, "transition");
        fragmentTransaction.commit();*/
    }

    @Override
    public void onClick(Route route, View view, int adapterPosition) {
        Toast.makeText(getActivity(), "Proximamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(Challenge challenge, View view, int adapterPosition) {
        Toast.makeText(getActivity(), "Proximamente GG", Toast.LENGTH_SHORT).show();

    }
}
