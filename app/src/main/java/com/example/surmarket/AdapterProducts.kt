package com.example.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class AdapterProducts(
    private val productsList: List<product>,
    private val clickOnBuy: (product) -> Unit
) : RecyclerView.Adapter<AdapterProducts.ViewHolderProduct>() {

    class ViewHolderProduct(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val category: TextView =
            itemView.findViewById(R.id.TXV_ITProductList_Category)

        val productName: TextView =
            itemView.findViewById(R.id.TXV_ITProductList_ProductName)

        val price: TextView =
            itemView.findViewById(R.id.TXV_ITProductList_Price)

        val buyButton: Button =
            itemView.findViewById(R.id.BTN_ITProductList_Buy)

        val productImage: ImageView =
            itemView.findViewById(R.id.IMV_ITProductList_ProductImage)

        val categoryText: String =
            itemView.context.getString(R.string.category)

        val priceText: String =
            itemView.context.getString(R.string.price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderProduct {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_productslist,
            parent,
            false
        )

        return ViewHolderProduct(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolderProduct,
        position: Int
    ) {
        val currentProduct = productsList[position]

        holder.category.text =
            "${holder.categoryText}: ${currentProduct.category}"

        holder.productName.text =
            currentProduct.name

        holder.price.text =
            "${holder.priceText}: %.2f Bs.".format(currentProduct.price)

        holder.productImage.setImageResource(
            R.drawable.surmarket
        )

        holder.buyButton.setOnClickListener {
            clickOnBuy(currentProduct)
        }
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun notifyChanged() {
        notifyDataSetChanged()
    }
}