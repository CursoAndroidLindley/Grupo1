package pe.lindley.tomapedidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import pe.lindley.tomapedidos.adapter.recyclerview.RVClienteAdapter;
import pe.lindley.tomapedidos.entities.Cliente;

public class ClienteActivity extends AppCompatActivity implements RVClienteAdapter.RVClienteAdapterListener {

    private RecyclerView cliente_rvcliente;
    private RVClienteAdapter rvClienteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_activity);

        cliente_rvcliente = (RecyclerView) findViewById(R.id.cliente_rvcliente);

        cliente_rvcliente.setHasFixedSize(true);
        cliente_rvcliente.setLayoutManager(new LinearLayoutManager(ClienteActivity.this));

        rvClienteAdapter = new RVClienteAdapter(ClienteActivity.this)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clientes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedItem(Cliente cliente, int position) {

    }
}
