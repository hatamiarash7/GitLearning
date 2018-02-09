/*
 * Copyright (c) 2017 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ir.hatamiarash.gitlearning.R;
import ir.hatamiarash.models.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
	private Context mContext;
	private List<Item> itemList;
	
	public ItemAdapter(Context mContext, List<Item> itemList) {
		this.mContext = mContext;
		this.itemList = itemList;
	}
	
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
		return new MyViewHolder(itemView);
	}
	
	@Override
	public void onBindViewHolder(final MyViewHolder holder, int position) {
		Item item = itemList.get(position);
		holder.title.setText(item.title);
		holder.description.setText(item.description);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public int getItemViewType(int position) {
		return position;
	}
	
	@Override
	public int getItemCount() {
		return itemList.size();
	}
	
	class MyViewHolder extends RecyclerView.ViewHolder {
		TextView title, description;
		
		MyViewHolder(View view) {
			super(view);
			title = view.findViewById(R.id.title);
			description = view.findViewById(R.id.description);
		}
	}
}