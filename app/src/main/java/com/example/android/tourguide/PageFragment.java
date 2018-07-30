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
    private static final String ARG_PAGE = "ARG_PAGE";
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

        final ArrayList<Attraction> words = new ArrayList<>();
        AttractionAdapter itemsAdapter = null;
        itemsAdapter = addAppriopriateWordsAndReturnAdapter(words, itemsAdapter);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    private AttractionAdapter addAppriopriateWordsAndReturnAdapter(ArrayList<Attraction> attractions, AttractionAdapter itemsAdapter) {
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
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.amusement_park),
                LocalTime.of(10, 00),
                LocalTime.of(21, 00),getString(com.example.android.tourguide.R.string.konstytucyjna_22_lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.rope_park),
                LocalTime.of(9, 00),
                LocalTime.of(20, 00), getString(com.example.android.tourguide.R.string.zgierka_200_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.zoo),
                LocalTime.of(10, 30),
                LocalTime.of(21, 30), getString(com.example.android.tourguide.R.string.kowaliowa_90_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.swimming_pool),
                LocalTime.of(8, 00),
                LocalTime.of(22, 00), getString(R.string.jana_pawła_20_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.thermal_baths),
                LocalTime.of(12, 00),
                LocalTime.of(18, 45), getString(com.example.android.tourguide.R.string.strykowska_12_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.aquapark),
                LocalTime.of(9, 15),
                LocalTime.of(22, 30), getString(com.example.android.tourguide.R.string.jakakolwiek_33_Zgierz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.trampoline_park),
                LocalTime.of(11, 00),
                LocalTime.of(21, 55), getString(com.example.android.tourguide.R.string.gdziekolwiek_99_Zgierz)));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_other);
    }

    private AttractionAdapter addMuseumsAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.city_museum),
                LocalTime.of(9, 00),
                LocalTime.of(18, 00), getString(com.example.android.tourguide.R.string.ogrodowa_15_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.canal_museum),
                LocalTime.of(12, 00),
                LocalTime.of(17, 30), getString(com.example.android.tourguide.R.string.plac_Wolnosci_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.art_museum),
                LocalTime.of(12, 00),
                LocalTime.of(18, 00), getString(com.example.android.tourguide.R.string.wieckowskiego_36_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.textile_museum),
                LocalTime.of(10, 40),
                LocalTime.of(19, 15), getString(com.example.android.tourguide.R.string.piotrkowska_282_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.cinematography_museum),
                LocalTime.of(11, 00),
                LocalTime.of(19, 00), getString(com.example.android.tourguide.R.string.pl_Zwycięstwa_1_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.animation_museum),
                LocalTime.of(10, 45),
                LocalTime.of(18, 45), getString(com.example.android.tourguide.R.string.pilsudskiego_135_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.archeology_museum),
                LocalTime.of(11, 00),
                LocalTime.of(17, 30), getString(com.example.android.tourguide.R.string.pl_Wolnosci_14_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.museum_of_independence),
                LocalTime.of(10, 35),
                LocalTime.of(18, 55), getString(com.example.android.tourguide.R.string.gdanska_13_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.book_art_museum),
                LocalTime.of(9, 30),
                LocalTime.of(18, 30), getString(com.example.android.tourguide.R.string.tymienieskiego_24_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.science_center),
                LocalTime.of(10, 00),
                LocalTime.of(20, 00), getString(com.example.android.tourguide.R.string.drewnowska_58_Lodz)));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_museum);
    }

    private AttractionAdapter addFoodAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.anatewka), LocalTime.of(10, 00),
                LocalTime.of(21, 00), getString(com.example.android.tourguide.R.string.sierpnia_22_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.galicja_restaurant),
                LocalTime.of(11, 00),
                LocalTime.of(21, 00), getString(com.example.android.tourguide.R.string.konstytucyjna_202_Lodz)));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.piwnica_lodzka), LocalTime.of(12, 30),
                LocalTime.of(23, 00), getString(com.example.android.tourguide.R.string.piotrkowska_32_Lodz)));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_food);
    }

    private AttractionAdapter addEventsAttractions(ArrayList<Attraction> attractions) {
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.light_Move_Festival),
                LocalDate.of(2018, 11, 12),
                                getString(com.example.android.tourguide.R.string.pl_Wolnosci_Lodz), R.drawable.light));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.food_Truck_Festival),
                LocalDate.of(2018, 8, 23),
                                getString(com.example.android.tourguide.R.string.piotrkowska_217_Lodz), R.drawable.food_truck));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.vegan_Food_Festival),
                LocalDate.of(2018, 10, 30),
                                        getString(com.example.android.tourguide.R.string.zgierska_28_Lodz), R.drawable.vegan));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.spanish_Cinematography_Festival),
                LocalDate.of(2018, 9, 12),
                                        getString(com.example.android.tourguide.R.string.sienkiewicza_17_Lodz), R.drawable.spain));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.days),
                LocalDate.of(2018, 12, 17),
                getString(com.example.android.tourguide.R.string.lodz), R.drawable.lodz));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.easter_parade),
                LocalDate.of(2019, 3, 29),
                                        getString(com.example.android.tourguide.R.string.piotrkowska_Lodz), R.drawable.easter));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.night_Skating), LocalDate.of(2019, 5, 4),
                                        getString(com.example.android.tourguide.R.string.dabrowskiego_Lodz), R.drawable.roller_skate));
        attractions.add(new Attraction(getString(com.example.android.tourguide.R.string.trip),
                LocalDate.of(2019, 1, 9),
                getString(com.example.android.tourguide.R.string.mickiewicza_18_Lodz), R.drawable.unknown_lodz));

        return new AttractionAdapter(getActivity(), attractions, R.color.attraction_event);
    }

}

