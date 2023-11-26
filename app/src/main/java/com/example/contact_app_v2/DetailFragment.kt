package com.example.contact_app_v2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class DetailFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("username")
        val phone = arguments?.getString("phone")
        val mail = arguments?.getString("email")
        val id = arguments?.getString("id")

        view.findViewById<TextView>(R.id.info_name).text = name
        view.findViewById<TextView>(R.id.info_phone).text = phone
        view.findViewById<TextView>(R.id.info_mail).text = mail
        view.findViewById<TextView>(R.id.info_id).text = id


        var back = view.findViewById<Button>(R.id.back_button)
        back.setOnClickListener{
            val navController = requireActivity().findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.contact_list)
        }


    }


}