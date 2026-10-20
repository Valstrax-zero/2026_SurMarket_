package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class FragmentProductsList : Fragment() {

    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    private val productsList = listOf(
        product(
            id = 1,
            name = "Arroz",
            category = "Alimentos",
            price = 4.50,
            imageUrl = "",
            description = "Arroz de primera calidad",
            available = true,
            stock = 20
        ),
        product(
            id = 2,
            name = "Aceite",
            category = "Alimentos",
            price = 12.00,
            imageUrl = "",
            description = "Aceite vegetal",
            available = true,
            stock = 15
        ),
        product(
            id = 3,
            name = "Azúcar",
            category = "Alimentos",
            price = 6.50,
            imageUrl = "",
            description = "Azúcar blanca",
            available = true,
            stock = 10
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_products_list,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(view)
        configureRecyclerView()
        configureListeners()
    }

    private fun initializeViews(view: View) {
        IMV_FRGProductsList_ShoppingCart =
            view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)

        IMV_FRGProductsList_Search =
            view.findViewById(R.id.IMV_FRGProductsList_Search)

        ETX_FRGProductsList_Search =
            view.findViewById(R.id.ETX_FRGProductsList_Search)

        BTN_FRGProductsList_AddProduct =
            view.findViewById(R.id.BTN_FRGProductsList_AddProduct)

        RCV_FRGProductsList_ProductsList =
            view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
    }

    private fun configureRecyclerView() {
        RCV_FRGProductsList_ProductsList.layoutManager =
            LinearLayoutManager(requireContext())

        RCV_FRGProductsList_ProductsList.adapter =
            AdapterProducts(productsList) { selectedProduct ->
                Toast.makeText(
                    requireContext(),
                    "Compraste ${selectedProduct.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun configureListeners() {
        BTN_FRGProductsList_AddProduct.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Añadir producto",
                Toast.LENGTH_SHORT
            ).show()
        }

        IMV_FRGProductsList_ShoppingCart.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Carrito de compras",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}