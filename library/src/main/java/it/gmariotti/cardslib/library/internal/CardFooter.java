package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.R;
import it.gmariotti.cardslib.library.internal.base.BaseCard;

/**
 * Created by mhatch on 3/23/2014.
 */
public class CardFooter extends BaseCard {

    protected OnClickLeftButtonListener mLeftClickListener;
    protected OnClickRightButtonListener mRightClickListener;

    protected String rightButtonText;
    protected String leftButtonText;

    public interface OnClickLeftButtonListener {
        public void onClick(Card card, View view);
    }

    public interface OnClickRightButtonListener {
        public void onClick(Card card, View view);
    }

    public CardFooter(Context context) {
        //default footer does not have text to display
        this(context, -1);
    }

    public CardFooter(Context context, int innerLayout) {
        super(context);
        mInnerLayout = innerLayout;
    }

    @Override
    public View getInnerView(Context context, ViewGroup parent) {

        View view = super.getInnerView(context, parent);

        //This provide a simple implementation with a single title
        if (view != null) {
            //Add inner view to parent
            parent.addView(view);

            //Setup value
            if (mInnerLayout > -1 )
                setupInnerViewElements(parent, view);
        }
        return view;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Add simple title to footer
        if (view != null) {
            TextView mTitleView = (TextView)view.findViewById(R.id.card_footer_inner_simple_title);
            if (mTitleView != null)
                mTitleView.setText(mTitle);
        }
    }

    public OnClickRightButtonListener getRightButtonClickListener() { return mRightClickListener; }

    public void setRightButtonListener(OnClickRightButtonListener listener) { mRightClickListener = listener; }

    public OnClickLeftButtonListener getLeftButtonClickListener() { return mLeftClickListener; }

    public void setLeftButtonListener(OnClickLeftButtonListener listener) { mLeftClickListener = listener; }

    public void setRightButtonText(String rightButtonText) { this.rightButtonText = rightButtonText; }

    public String getRightButtonText() { return rightButtonText; }

    public void setLeftButtonText(String leftButtonText) {this.leftButtonText = leftButtonText; }

    public String getLeftButtonText() { return leftButtonText; }
}