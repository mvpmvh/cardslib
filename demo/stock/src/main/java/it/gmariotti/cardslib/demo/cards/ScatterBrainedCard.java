package it.gmariotti.cardslib.demo.cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.gmariotti.cardslib.demo.R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardFooter;
import it.gmariotti.cardslib.library.internal.CardHeader;

/**
 * Created by mhatch on 4/5/2014.
 */
public class ScatterBrainedCard extends Card {

    public int USE_VIGNETTE=0;

    public ScatterBrainedCard(Context context) {
        super(context, R.layout.scatterbrained_inner_main);
        init();
    }

    public ScatterBrainedCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    private void init() {
       ScatterBrainedHeader header = new ScatterBrainedHeader(getContext(), R.layout.scatterbrained_inner_header);
        header.gameCreator = "Michael Hatch";
        header.gameTitle = "Foo";
        addCardHeader(header);

        ScatterBrainedFooter footer = new ScatterBrainedFooter(getContext());
        addCardFooter(footer);
    }

    private class ScatterBrainedHeader extends CardHeader {
        String gameTitle;
        String gameCreator;
        ImageView letter;
        ImageView round;

        public ScatterBrainedHeader(Context context, int innerLayout) {
            super(context, innerLayout);
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {

            TextView title = (TextView) view.findViewById(R.id.game_title);
            TextView creator = (TextView) view.findViewById(R.id.game_creator);
            ImageView imageView = (ImageView) view.findViewById(R.id.scatterbrained_header_image);
            ImageView letter = (ImageView) view.findViewById(R.id.scatterbrained_letter);
            ImageView round = (ImageView) view.findViewById(R.id.scatterbrained_round);

            title.setText(gameTitle);
            creator.setText(gameCreator);
            imageView.setImageResource(R.drawable.ic_ic_error_loading);
            letter.setImageResource(R.drawable.ic_ic_error_loading);
            round.setImageResource(R.drawable.ic_ic_error_loading);
        }
    }

    private class ScatterBrainedFooter extends CardFooter {

        public ScatterBrainedFooter(Context context) {
            super(context);
            setLeftButtonText("Decline");
            setRightButtonText("Join");
        }
    }
}
