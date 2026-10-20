package com.example.surmarket

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class AdapterProducts(
    private val productsList: List<product>,
    private val clickOnBuy: (product) -> Unit
) : RecyclerView.Adapter<AdapterProducts.ViewHolderProduct>() {

    class ViewHolderProduct(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderProduct {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: ViewHolderProduct,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}