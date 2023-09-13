package com.example.lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.zip.Inflater;

public class ChurrascoAdapter  extends ArrayAdapter<Churrasco> {
    Context myContext;
    int myResource;
    public ChurrascoAdapter(@NonNull Context context, int resource, @NonNull List<Churrasco> objects) {
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View itemlista = inflater.inflate(myResource, parent,false);

        return convertView;

        //return super.getView(position, convertView, parent);
    }
}
