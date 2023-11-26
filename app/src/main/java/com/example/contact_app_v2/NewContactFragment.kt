package com.example.contact_app_v2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.contact_app_v2.model.Person

class NewContactFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_contact, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<EditText>(R.id.name_input)
        val phone = view.findViewById<EditText>(R.id.phone_input)
        val email = view.findViewById<EditText>(R.id.email_input)
        val createButton = view.findViewById<Button>(R.id.create_button)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)

        createButton.setOnClickListener {
            val contact = Person ( MainActivity.contacts.size + 1,name.text.toString(), phone.text.toString(), email.text.toString() )
            MainActivity.contacts.add(contact)
            Toast.makeText(requireContext(), "Contact created", Toast.LENGTH_SHORT).show()
            navigateToHome()
        }

        cancelButton.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val navController = requireActivity().findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.contact_list)
    }
}