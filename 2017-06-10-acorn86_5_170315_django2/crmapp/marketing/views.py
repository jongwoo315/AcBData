from django.shortcuts import render

# Create your views here.

# The marketing app will be used to
# store parts of the application
# responsible for displaying the home page
# and any future marketing related pages.

# ===== definition of views:
# Python function or class
# that takes a web request and return a web response

# ===== usage
# Views are used to do things like
# fetch objects from the database,
# modify those objects if needed,
# render forms,
# return HTML, and much more.

from django.views.generic.base import TemplateView

class HomePage(TemplateView):
    template_name = 'marketing/home.html'
