#-*-encoding:utf-8-*-
from __future__ import unicode_literals
from django.db import models
from django.contrib.auth.models import User

# models.Model을 하위클래스로 가지는 Subscriber 클래스를 생성
class Subscriber(models.Model):
    USERNAME_FIELD = 'user'
    # user_rec은 Subscriber의 속성 중 하나(SQL에서). 또한, ForeignKey(User)를 통해
    # User모델과의 관계성(외부키)이 생긴다
    user_rec = models.ForeignKey(User)
    address_one = models.CharField(max_length=100)
    address_two = models.CharField(max_length=100, blank=True)
    city = models.CharField(max_length=50)
    state = models.CharField(max_length=2)
    stripe_id = models.CharField(max_length=30, blank=True)

    # model에 metadata 제공
    class Meta:
        verbose_name_plural = 'subscribers'

    # admin 화면 우측에 나타나는 것
    # define a unicode representation of objects in the model
    def __unicode__(self):
        return u"%s's subscription info" % self.user_rec

# 여기까지 하고 나서는 데이터베이스에 적용이 필요하므로 makemigrations, migrate를 해야 한다
