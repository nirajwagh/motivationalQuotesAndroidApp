package in.waghtech.motivationalquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Random;

public class myAdapter extends PagerAdapter {

    private Context context;
    private String[] quotes;
    private LayoutInflater inflater;
    private TextView textView;
    private Random random=new Random();
    private int i;
    private CallBack callBack;

    private  String[] background={"a","b","c","d","e","f","g","h","i","j","l","m","n","o","p","q","s"
            ,"u","v","x","y","z","aa","bb","cc","ee","ff","gg","hh","jj","kk"
            ,"ll","mm","nn","pp","qq","ss","uu","vv","ww","xx","yy","zz","aaa","bbb"
            ,"ccc","ddd","eee","b1","b2","c1","c2","d1","d2","e1","e2","f1","f2","g1","g2","h1"
            ,"h2","i1","i2","j1","j2","k1","k2","l2","m1","m2","n1","n2","o1","o2","p1","p2","q1"
            ,"q2","r1","r2","s1","s2","t1","t2","u1","u2","v1","v2","w1","w2","x1","x2","y1","z1"
    };

    public myAdapter(Context context, String[] quotes, CallBack callBack) {
        this.context = context;
        this.quotes = quotes;
        this.callBack = callBack;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return quotes.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.mylayout, container, false);
        container.addView(view);
        textView = view.findViewById(R.id.textView);
        final CardView cardView = view.findViewById(R.id.cardView);
        textView.setText(quotes[position]);
        i= context.getResources().getIdentifier(background[random.nextInt(57)], "drawable", context.getPackageName());
        textView.setBackgroundResource(i);
        textView.getBackground().setAlpha(90);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                callBack.onLongClick(cardView);
                return false;
            }
        });
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }
    public interface CallBack {
        void onLongClick(CardView cardView);
    }

}