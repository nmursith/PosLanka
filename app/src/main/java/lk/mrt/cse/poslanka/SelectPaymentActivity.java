package lk.mrt.cse.poslanka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class SelectPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_payment_method);
    }

    public void processPayment(View view) {
        HashMap<String,String> data = new HashMap<>();
        Connection connection = Connection.getInstance();
        data.put("name_on_card","Mohamed Nifras");
        data.put("amount", "10");
        data.put("card_type","visa");
        data.put("card_number","4032 0391 0542 2911");
        data.put("expiry_month","12");
        data.put("expiry_year","2021");
        data.put("cvv","123");
        data.put("orderID","12324");


        try {
            String results = connection.post("payment_process.php",data);
            Log.e("Resulst", results);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
