from __future__ import unicode_literals

from django.db import models
from django.contrib.auth.models import User
from django.conf import settings
# Create your models here.

class Subscriber(models.Model):
    USERNAME_FIELD = 'username'
    user_rec = models.ForeignKey(User)
    address_one = models.CharField(max_length=100)
    address_two = models.CharField(max_length=100, blank=True)
    city = models.CharField(max_length=50)
    state = models.CharField(max_length=2)
    stripe_id = models.CharField(max_length=30, blank=True)
    class Meta:
        verbose_name_plural = 'subscribers'
    def __str__(self):
        return u"%s's Subscription Info" % self.user_rec
