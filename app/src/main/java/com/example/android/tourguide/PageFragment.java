package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 * Created by klaudia on 29/07/18.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list_view, container, false);

        final ArrayList<Attraction> words = new ArrayList<Attraction>();
        AttractionAdapter itemsAdapter = null;
        itemsAdapter = addAppriopriateWords(words, itemsAdapter);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    private AttractionAdapter addAppriopriateWords(ArrayList<Attraction> attractions, AttractionAdapter itemsAdapter) {
        switch (mPage) {
            case 0: itemsAdapter = addEventsAttractions(attractions);
                break;
            case 1: itemsAdapter = addFoodAttractions(attractions);
                break;
            case 2: itemsAdapter = addMuseumsAttractions(attractions);
                break;
            case 3: itemsAdapter = addOtherAttractions(attractions);
                break;
        }
        return itemsAdapter;
    }

    private AttractionAdapter addOtherAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction("Amusement Park", LocalTime.of(10, 00),
                                        LocalTime.of(21, 00), "Konstytucyjna 22, Lodz"));
        attractions.add(new Attraction("Rope Park", LocalTime.of(9, 00),
                LocalTime.of(20, 00), "Zgierka 200, Lodz"));
        attractions.add(new Attraction("Zoo", LocalTime.of(10, 30),
                LocalTime.of(21, 30), "Kowaliowa 90, Lodz"));
        attractions.add(new Attraction("Swimming Pool", LocalTime.of(8, 00),
                LocalTime.of(22, 00), "Jana Pawła 20, Lodz"));
        attractions.add(new Attraction("Thermal baths", LocalTime.of(12, 00),
                LocalTime.of(18, 45), "Strykowska 12, Lodz"));
        attractions.add(new Attraction("Aquapark", LocalTime.of(9, 15),
                LocalTime.of(22, 30), "Jakakolwiek 33, Zgierz"));
        attractions.add(new Attraction("Trampoline Park", LocalTime.of(11, 00),
                LocalTime.of(21, 55), "Gdziekolwiek 99, Zgierz"));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_other);
    }

    private AttractionAdapter addMuseumsAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction("Lodz City Museum", LocalTime.of(9, 00),
                LocalTime.of(18, 00), "Ogrodowa 15, Lodz"));
        attractions.add(new Attraction("'Dętka' Canal Museum", LocalTime.of(12, 00),
                LocalTime.of(17, 30), "plac Wolności, Lodz"));
        attractions.add(new Attraction("Art Museum", LocalTime.of(12, 00),
                LocalTime.of(18, 00), "Więckowskiego 36, Lodz"));
        attractions.add(new Attraction("Textile Museum", LocalTime.of(10, 40),
                LocalTime.of(19, 15), "Piotrkowska 282, Lodz"));
        attractions.add(new Attraction("Cinematography Museum", LocalTime.of(11, 00),
                LocalTime.of(19, 00), "p. Zwycięstwa 1, Lodz"));
        attractions.add(new Attraction("'Se-ma-for' Animation Museum", LocalTime.of(10, 45),
                LocalTime.of(18, 45), "Piłsudskiego 135, Lodz"));
        attractions.add(new Attraction("Archeology Museum", LocalTime.of(11, 00),
                LocalTime.of(17, 30), "pl. Wolności 14, Lodz"));
        attractions.add(new Attraction("Museum of Independence", LocalTime.of(10, 35),
                LocalTime.of(18, 55), "Gdańska 13, Lodz"));
        attractions.add(new Attraction("Book Art Museum", LocalTime.of(9, 30),
                LocalTime.of(18, 30), "Tymienieskiego 24, Lodz"));
        attractions.add(new Attraction("Science Center 'Experymentarium'", LocalTime.of(10, 00),
                LocalTime.of(20, 00), "Drewnowska 58, Lodz"));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_museum);
    }

    private AttractionAdapter addFoodAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction("Anatewka", LocalTime.of(10, 00),
                LocalTime.of(21, 00), "6 sierpnia 22, Lodz"));
        attractions.add(new Attraction("Galicja Restaurant", LocalTime.of(11, 00),
                LocalTime.of(21, 00), "Konstytucyjna 202, Lodz"));
        attractions.add(new Attraction("Piwnica Łódzka", LocalTime.of(12, 30),
                LocalTime.of(23, 00), "Piotrkowska 32, Lodz"));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_food);
    }

    private AttractionAdapter addEventsAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction("Light Move Festival", LocalDate.of(2018, 11, 12),
                                "pl. Wolności, Lodz", R.drawable.light));
        attractions.add(new Attraction("Food Truck Festival", LocalDate.of(2018, 8, 23),
                                "pl. Wolności, Lodz", R.drawable.food_truck));
        attractions.add(new Attraction("Vegan Food Festival", LocalDate.of(2018, 10, 30),
                                        "pl. Wolności, Lodz", R.drawable.vegan));
        attractions.add(new Attraction("Spanish Cinematography Festival", LocalDate.of(2018, 9, 12),
                                        "pl. Wolności, Lodz", R.drawable.spain));
        attractions.add(new Attraction("Łódź's Days", LocalDate.of(2018, 12, 17),
                                        "pl. Wolności, Lodz", R.drawable.lodz));
        attractions.add(new Attraction("Easter Parade", LocalDate.of(2019, 3, 29),
                                        "pl. Wolności, Lodz", R.drawable.easter));
        attractions.add(new Attraction("Night Skating - Roller skates", LocalDate.of(2019, 5, 4),
                                        "pl. Wolności, Lodz", R.drawable.roller_skate));
        attractions.add(new Attraction("'Unknown Łódź' Trip", LocalDate.of(2019, 1, 9),
                                        "pl. Wolności, Lodz", R.drawable.unknown_lodz));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_event);
    }

}

