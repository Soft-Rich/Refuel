package be.ehb.digx.refuel.refuelings;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.databinding.LayoutRefuelingHeaderBinding;
import be.ehb.digx.refuel.databinding.LayoutRefuelingItemBinding;
import be.ehb.digx.refuel.refuelings.view.model.RefuelingsUI;
import be.ehb.digx.refuel.util.DateTime;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsStickyListAdapter  extends BaseAdapter implements StickyListHeadersAdapter {

    LayoutInflater inflater;
    List<RefuelingsUI> refuelingsUIList = new ArrayList<>();
    LayoutRefuelingHeaderBinding layoutRefuelingHeaderBinding;
    LayoutRefuelingItemBinding layoutRefuelingItemBinding;

    public RefuelingsStickyListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        //if (convertView == null) {
            layoutRefuelingHeaderBinding = DataBindingUtil.inflate(inflater, R.layout.layout_refueling_header, parent, false);
            layoutRefuelingHeaderBinding.setRefuelingHeader(refuelingsUIList.get(position));
            convertView = layoutRefuelingHeaderBinding.getRoot();
        //}
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        long result = DateTime.getMonthYearId(refuelingsUIList.get(position).getDateHeaderFormat());
        return result;
    }

    @Override
    public int getCount() {
        if (this.refuelingsUIList == null){
            return 0;
        }
        return this.refuelingsUIList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.refuelingsUIList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
       // if (convertView == null) {
            layoutRefuelingItemBinding = DataBindingUtil.inflate(inflater, R.layout.layout_refueling_item, parent, false);
            layoutRefuelingItemBinding.setRefueling(refuelingsUIList.get(i));
            convertView = layoutRefuelingItemBinding.getRoot();
        //}
        return convertView;
    }


    public void setRefuelings(List<RefuelingsUI> refuelingsUIList){
        this.refuelingsUIList = refuelingsUIList;
    }
}