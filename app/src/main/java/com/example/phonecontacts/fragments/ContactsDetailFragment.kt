package com.example.phonecontacts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.phonecontacts.R
import com.example.phonecontacts.models.Person

class ContactsDetailFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var fName : TextView
    private lateinit var name : TextView
    private lateinit var phone : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)
        fName = view.findViewById(R.id.last_name_text_view)
        name = view.findViewById(R.id.name_text_view)
        phone = view.findViewById(R.id.phone_text_view)

        val args = arguments?.getParcelable<Person>(PERSON_DETAIL_ARG)
        fName.text = args!!.f_name
        name.text = args.name
        phone.text = args.phone

        Glide
            .with(imageView)
            .load(args.image_url)
            .into(imageView)
    }

    companion object {
        private const val PERSON_DETAIL_ARG = "name"

        fun newInstance(person: Person) = ContactsDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(PERSON_DETAIL_ARG, person)
            }
        }
    }
}