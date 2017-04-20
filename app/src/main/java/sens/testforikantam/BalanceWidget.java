package sens.testforikantam;

/**
 * Created by User on 20.04.2017.
 */

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

public class BalanceWidget extends ConstraintLayout {

    ImageView imgSlider;
    ConstraintLayout main;
    ConstraintSet set;
    AutoTransition autoTransition;

    public BalanceWidget(Context context) {
        this(context, null);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.component_layout, this, true);
        imgSlider = (ImageView) findViewById(R.id.imgSlider);
        main = (ConstraintLayout) findViewById(R.id.child);
        set = new ConstraintSet();
        autoTransition = new AutoTransition();
        autoTransition.setDuration(200); // Исходя из требований о вызове weightChange 5 раз в секунду
    }

    public BalanceWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BalanceWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void weightChange (double left, double right) {
        float position = (float)(left/(left+right));
        /* Можно ввести проерку вида Float.isNaN(), если требуется исключить ситуацию когда left+right = 0,
        но в данном случае (если NaN) slider по свойству app:layout_constraintHorizontal_bias="0.5" сам возвращается на середину, а приложение не падает */
        System.out.println("!!! position " + position);
        set.clone(main);
        TransitionManager.beginDelayedTransition(main, autoTransition);
        set.setHorizontalBias(imgSlider.getId(), position);
        set.applyTo(main);
    }
}
