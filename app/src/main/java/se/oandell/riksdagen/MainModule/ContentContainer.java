package se.oandell.riksdagen.MainModule;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import se.oandell.riksdagen.R;

/**
 * Created by Oscar on 2017-03-24.
 */
public class ContentContainer extends LinearLayout{

    private TextView titleTextView;
    private TextView contentTextView;
    private TextView footerTextView;
    private ImageView portraitImageView;
    private ImageView bottomImageView;
    private View divider;

    public ContentContainer(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newsView = inflater.inflate(R.layout.news_layout,null);



        this.setOrientation(LinearLayout.VERTICAL);

        //Create horizontal layout in which to place potential portrait and title text.
        //This is done so they can be placed next to each other
        LinearLayout imageAndTitleLayout = new LinearLayout(context);
        imageAndTitleLayout.setOrientation(HORIZONTAL);
        this.addView(imageAndTitleLayout);

        //Title text
        titleTextView = (TextView) newsView.findViewById(R.id.news_title);
        contentTextView = (TextView) newsView.findViewById(R.id.news_body);
        footerTextView = (TextView) newsView.findViewById(R.id.news_footer);
        bottomImageView = (ImageView) newsView.findViewById(R.id.news_image);
        portraitImageView = (ImageView) newsView.findViewById(R.id.news_image_bottom);


        this.addView(newsView);
    }

    public void addPortrait(Bitmap img){
        if(img!=null){
            Bitmap imgScaled = Bitmap.createScaledBitmap(img,192,256, true); //Rescale bitmap is necessary for some reason
            portraitImageView.setPadding(0,0,20,0);
            portraitImageView.setImageBitmap(imgScaled);
        }
    }

    public void addImage(Bitmap img){
        if(img!=null){
            bottomImageView.setImageBitmap(img);
        }
    }

    public void addImage(int imgID){
        bottomImageView.setImageResource(imgID);
    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }

    public String getTitle(){
        return titleTextView.getText().toString();
    }

    public void setText(String text){
        contentTextView.setText(text);
    }

    public String getText(){
        return contentTextView.getText().toString();
    }

    public TextView getFooterTextView(){
        return footerTextView;
    }


}
