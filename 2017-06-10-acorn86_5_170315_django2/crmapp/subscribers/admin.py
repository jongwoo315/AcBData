from django.contrib import admin
from .models import Subscriber

# This is the line that registers the Subscriber model with the Admin Site.
admin.site.register(Subscriber)
