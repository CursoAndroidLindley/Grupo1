package pe.lindley.tomapedidos.dao;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pe.lindley.tomapedidos.entities.Cliente;

/**
 * Created by jlama on 19/09/2015.
 */
public class ClienteDAO {
    private static ClienteDAO INSTANCE = new ClienteDAO();

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClienteDAO();
        }
    }

    public List<Cliente> getListaCliente() {
        List<Cliente> lista = new ArrayList<Cliente>();
        Cursor cursor = null;
        try {
            cursor = DataBaseHelper.myDataBase.query("TB_Cliente", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    Cliente cliente = new Cliente();
                    cliente.setClienteId(cursor.isNull(cursor.getColumnIndex("Cliente_Id")) ? 0 : cursor.getInt(cursor.getColumnIndex("Cliente_Id")));
                    cliente.setClienteRazonSocial(cursor.isNull(cursor.getColumnIndex("Cliente_RazonSocial")) ? "" : cursor.getString(cursor.getColumnIndex("Cliente_RazonSocial")));
                    cliente.setClienteNIT(cursor.isNull(cursor.getColumnIndex("Cliente_NIT")) ? "" : cursor.getString(cursor.getColumnIndex("Cliente_NIT")));
                    cliente.setClienteDireccion(cursor.isNull(cursor.getColumnIndex("Cliente_Direccion")) ? "" : cursor.getString(cursor.getColumnIndex("Cliente_Direccion")));
                    cliente.setClienteGiroNegocio(cursor.isNull(cursor.getColumnIndex("Cliente_GiroNegocio")) ? "" : cursor.getString(cursor.getColumnIndex("Cliente_GiroNegocio")));
                    cliente.setClienteAltitud(cursor.isNull(cursor.getColumnIndex("Altitud")) ? "" : cursor.getString(cursor.getColumnIndex("Altitud")));
                    cliente.setClienteLatitud(cursor.isNull(cursor.getColumnIndex("Latitud")) ? "" : cursor.getString(cursor.getColumnIndex("Latitud")));
                    lista.add(cliente);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return lista;
    }
}
