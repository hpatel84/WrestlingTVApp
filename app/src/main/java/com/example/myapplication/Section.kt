package com.example.myapplication

import java.io.Serializable

data class Section(
    var title: String? = null,
    var movies: ArrayList<Movie>? = null
) : Serializable {
    override fun toString(): String {
        return "Section{" +
                "title=" + title +
                ", Movie='" + movies.toString() + '\'' +
                '}'
    }

    companion object {
        internal const val serialVersionUID = 727566175075960653L
    }
}
