package com.google.codelab.github_search_repository.view

import android.view.View
import com.google.codelab.github_search_repository.R
import com.google.codelab.github_search_repository.databinding.CellRepositoryBinding
import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class RepositoryItemsFactory(
    private val item: SearchRepositoryBusinessModel
) : BindableItem<CellRepositoryBinding>() {
    override fun getLayout() = R.layout.cell_repository

    override fun bind(viewBinding: CellRepositoryBinding, position: Int) {
        viewBinding.item = item
    }

    override fun initializeViewBinding(view: View): CellRepositoryBinding {
        return CellRepositoryBinding.bind(view)
    }

    override fun isSameAs(other: Item<*>): Boolean =
        (other as? RepositoryItemsFactory)?.item?.id == item.id
}
