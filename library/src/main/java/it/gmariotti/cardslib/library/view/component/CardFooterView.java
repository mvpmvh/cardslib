package it.gmariotti.cardslib.library.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import it.gmariotti.cardslib.library.R;
import it.gmariotti.cardslib.library.internal.CardFooter;
import it.gmariotti.cardslib.library.view.base.CardViewInterface;

/**
 * Created by mhatch on 3/23/2014.
 */
public class CardFooterView extends FrameLayout implements CardViewInterface {

    //default footer layout
    protected int card_footer_layout_resourceID = R.layout.base_footer_layout;

    protected View mInternalOuterView;

    protected Button leftButton;
    protected Button rightButton;

    protected CardFooter mCardFooter;

    protected boolean mIsRecycle = false;

    protected boolean mForceReplaceInnerLayout = false;

    public CardFooterView(Context context) {
        super(context);
        init(null, 0);
    }

    public CardFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CardFooterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);

        if (!isInEditMode())
            initView();
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.card_options, defStyle, defStyle);

        try {
            card_footer_layout_resourceID = a.getResourceId(R.styleable.card_options_card_footer_layout_resourceID, card_footer_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    protected void initView() {

        //Inflate the root view (outerView)
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInternalOuterView = inflater.inflate(card_footer_layout_resourceID, this, true);

        leftButton = (Button) findViewById(R.id.footer_left_button);
        rightButton = (Button) findViewById(R.id.footer_right_button);
    }

    @Override
    public View getInternalOuterView() {
        return mInternalOuterView;
    }

    public void addCardFooter(CardFooter cardFooter) {
        mCardFooter = cardFooter;
        buildUI();
    }

    protected void buildUI() {
        if (mCardFooter == null) return;

        //Set button visibility
        setupButtons();

        //Setup InnerView
        //setupInnerView();
    }

    private void setupButtons() {

        leftButton.setText(mCardFooter.getLeftButtonText());
        rightButton.setText(mCardFooter.getRightButtonText());

        if(mCardFooter.getLeftButtonClickListener() != null) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCardFooter.getLeftButtonClickListener()!= null)
                        mCardFooter.getLeftButtonClickListener().onClick(mCardFooter.getParentCard(), v);
                }
            });
        }

        if(mCardFooter.getRightButtonClickListener() != null) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCardFooter.getRightButtonClickListener() != null) {
                        mCardFooter.getRightButtonClickListener().onClick(mCardFooter.getParentCard(), v);
                    }
                }
            });
        }
    }

    public void setRecycle(boolean isRecycle) {
        this.mIsRecycle = isRecycle;
    }

    public void setForceReplaceInnerLayout(boolean forceReplaceInnerLayout) {
        this.mForceReplaceInnerLayout = forceReplaceInnerLayout;
    }
}
