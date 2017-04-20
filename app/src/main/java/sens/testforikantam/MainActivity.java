package sens.testforikantam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    BalanceWidget view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout parent = (LinearLayout)findViewById(R.id.parent);
        view = new BalanceWidget(MainActivity.this);
        parent.addView(view);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.weightChange (0, 0);
            }});
        button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Генерируем веса
                view.weightChange (new Random().nextDouble(), new Random().nextDouble());
            }});
    }
}
