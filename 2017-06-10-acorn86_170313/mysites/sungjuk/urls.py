from django.conf.urls import url
from sungjuk import views

urlpatterns = [
    url(r'^$', views.SungjukList.as_view(), name='sungjuk_list'),
    url(r'^new$', views.SungjukCreate.as_view(), name='sungjuk_new'),
    url(r'^edit/(?P<pk>\d+)$', views.SungjukUpdate.as_view(), name='sungjuk_edit'),
    url(r'^delete/(?P<pk>\d+)$', views.SungjukDelete.as_view(), name='sungjuk_delete'),
]
