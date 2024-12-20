package com.example.ihateprogrammingavz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepairRequestAdapter extends RecyclerView.Adapter<RepairRequestAdapter.ViewHolder> {

    private List<RepairRequest> repairRequests;

    public RepairRequestAdapter(List<RepairRequest> repairRequests) {
        this.repairRequests = repairRequests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repair_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RepairRequest request = repairRequests.get(position);
        holder.tvDeviceName.setText(request.getDeviceName());
        holder.tvWorkType.setText(request.getWorkType());
        holder.tvCompletionTime.setText(request.getCompletionTime());
    }

    @Override
    public int getItemCount() {
        return repairRequests.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDeviceName, tvWorkType, tvCompletionTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDeviceName = itemView.findViewById(R.id.tvDeviceName);
            tvWorkType = itemView.findViewById(R.id.tvWorkType);
            tvCompletionTime = itemView.findViewById(R.id.tvCompletionTime);
        }
    }
}
