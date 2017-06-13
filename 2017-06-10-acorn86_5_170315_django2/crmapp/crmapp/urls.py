# -*-encoding:utf-8-*-
"""crmapp URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.10/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url
from django.contrib import admin

# from marketing.views import HomePage
import marketing.views
# from subscribers.views import subscriber_new
import subscribers.views
from django.contrib.auth import views as auth_views
import accounts.views
import accounts.urls

admin.autodiscover()

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^$', marketing.views.HomePage.as_view(), name="home"),
    # name에 붙인 sub_new는 html파일에서 a href=안에 쓰인다.
    url(r'^signup/$', subscribers.views.subscriber_new, name='sub_new'),
    # url(r'^login/$', login, {'template_name':'login.html',}),
    # url(r'^logout/$', logout, {'next_page':'/login',}),
    # name='login'을 해놔야 urls.py(현재 파일)에서 login.html을 띄울 수
    # url(r'^login/$', login, {'template_name':'login.html'}, name='login'),
    url(r'^login/$', auth_views.login, {'template_name':'login.html'}, name='login'),
    url(r'^logout/$', auth_views.logout, {'next_page':'/login'}),

    url(r'^account/list/$', accounts.views.AccountList.as_view(), name='account_list'),
    url(r'^account/(?P<uuid>[\w-]+)/', include(account_urls)),
]
