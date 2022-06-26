package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import coil.load
import com.danielcano.imdbapp.R

class MovieDetailsFragment : Fragment() {

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        val navController = findNavController()
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.setupWithNavController(navController)
        toolbar.title = args.name
        view.findViewById<TextView>(R.id.name_es).text = args.nameEs
        view.findViewById<TextView>(R.id.name).text = args.name
        view.findViewById<TextView>(R.id.synopsis).text = args.synopsis
        val prevView = view.findViewById<ImageView>(R.id.previewImage)
        prevView?.let {
            view.findViewById<ImageView>(R.id.previewImage).load(args.preview)
        }
        val thumbView = view.findViewById<ImageView>(R.id.movieThumbnailImage)
            .load(args.thumbnail)
        thumbView?.let {
            view.findViewById<ImageView>(R.id.movieThumbnailImage).load(args.thumbnail)
        }
        return view
    }
}