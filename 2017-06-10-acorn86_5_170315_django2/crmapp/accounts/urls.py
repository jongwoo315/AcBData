from django.conf.urls import url
import accounts.views

account_urls = [
    url(r'^$', accounts.views.account_detail, name='account_detail'),
]
