from django.urls import path, include

import blog.views
urlpatterns = [
    path('hello_world',blog.views.hello_world),
    path('content', blog.views.article_content),
    path('index', blog.views.get_index_page),
    # path('detail', blog.views.get_detail_page),
    path('detail/<int:article_id>', blog.views.get_detail_page),
    path('edit/<int:article_id>', blog.views.edit_page,name='edit_page'),
    path('edit_action', blog.views.edit_action,name='edit_action'),
    path('delete/<int:article_id>', blog.views.delete_action,name='delete_action'),
]