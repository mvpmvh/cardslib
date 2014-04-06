package it.gmariotti.cardslib.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import it.gmariotti.cardslib.demo.R;
import it.gmariotti.cardslib.demo.cards.GoogleNowBirthCard;
import it.gmariotti.cardslib.demo.cards.ScatterBrainedCard;
import it.gmariotti.cardslib.library.view.CardView;

/**
 * Created by mhatch on 4/5/2014.
 */
public class ScatterBrainedFragment extends BaseFragment {
    protected ScrollView mScrollView;
    private CardView cardView;
    private ScatterBrainedCard sbCard;

    @Override
    public int getTitleResourceId() {
        return R.string.scatterbrained_title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.scatterbrained_fragment_card, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mScrollView = (ScrollView) getActivity().findViewById(R.id.card_scrollview);
        initCard();
    }

    /**
     * This method builds a simple card
     */
    private void initCard() {
        init1();
        //init2();
        //init3();
    }

    private void init1(){
        //Create a Card
        sbCard = new ScatterBrainedCard(getActivity());
        sbCard.setId("myId");

        //Set card in the cardView
        cardView = (CardView) getActivity().findViewById(R.id.scatterbrained_card1);
        cardView.setCard(sbCard);
    }

    /*private void init2(){
        GoogleNowBirthCard card2 = new GoogleNowBirthCard(getActivity());
        card2.setId("myId2");
        card2.USE_VIGNETTE=1;

        //Set card in the cardView
        CardView cardView2 = (CardView) getActivity().findViewById(R.id.carddemo_cardBirth2);
        cardView2.setCard(card2);

    }

    private void init3(){
        GoogleNowBirthCard card3 = new GoogleNowBirthCard(getActivity());
        card3.setId("myId3");
        card3.USE_VIGNETTE=2;

        //Set card in the cardView
        CardView cardView3 = (CardView) getActivity().findViewById(R.id.carddemo_cardBirth3);
        cardView3.setCard(card3);
    }*/
}