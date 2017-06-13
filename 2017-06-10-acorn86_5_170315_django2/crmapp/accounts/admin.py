# -*-encoding:utf-8-*-
from django.contrib import admin
from .models import Account

# 여기에 아래 내용을 추가해야 관리자 페이지에 Account가 뜬다
admin.site.register(Account)
