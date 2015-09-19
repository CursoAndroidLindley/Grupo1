package pe.lindley.tomapedidos.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jlama on 19/09/2015.
 */
public class Cliente implements Parcelable {
    private int clienteId;
    private String clienteRazonSocial;
    //NIT: Número de indentificador tritutario
    private String clienteNIT;
    private String clienteGiroNegocio;
    private String clienteDireccion;
    // para las coordenadas
    private String clienteLatitud;
    private String clienteAltitud;

    public Cliente() {
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteRazonSocial() {
        return clienteRazonSocial;
    }

    public void setClienteRazonSocial(String clienteRazonSocial) {
        this.clienteRazonSocial = clienteRazonSocial;
    }

    public String getClienteNIT() {
        return clienteNIT;
    }

    public void setClienteNIT(String clienteNIT) {
        this.clienteNIT = clienteNIT;
    }

    public String getClienteLatitud() {
        return clienteLatitud;
    }

    public void setClienteLatitud(String clienteLatitud) {
        this.clienteLatitud = clienteLatitud;
    }

    public String getClienteAltitud() {
        return clienteAltitud;
    }

    public void setClienteAltitud(String clienteAltitud) {
        this.clienteAltitud = clienteAltitud;
    }

    protected Cliente(Parcel in) {
        clienteId = in.readInt();
        clienteRazonSocial = in.readString();
        clienteNIT = in.readString();
        clienteDireccion = in.readString();
        clienteGiroNegocio = in.readString();
        clienteLatitud = in.readString();
        clienteAltitud = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(clienteId);
        dest.writeString(clienteRazonSocial);
        dest.writeString(clienteNIT);
        dest.writeString(clienteDireccion);
        dest.writeString(clienteGiroNegocio);
        dest.writeString(clienteLatitud);
        dest.writeString(clienteAltitud);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getClienteGiroNegocio() {
        return clienteGiroNegocio;
    }

    public void setClienteGiroNegocio(String clienteGiroNegocio) {
        this.clienteGiroNegocio = clienteGiroNegocio;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }
}
