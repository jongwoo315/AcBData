from django.shortcuts import render
# Create your views here.
from django.contrib.auth.models import User
from django.http import HttpResponseRedirect
from django.contrib.auth import authenticate, login
from django.forms.forms import NON_FIELD_ERRORS
from django.conf import settings
from django.core.urlresolvers import reverse
from .forms import SubscriberForm
from .models import Subscriber

def subscriber_new(request, template='subscribers/subscribers_new.html'):
    form = SubscriberForm(request.POST or None)
    #form = SubscriberForm(request.POST)
    if request.method == 'POST':
        form = SubscriberForm(request.POST)
        if form.is_valid():
            username = form.cleaned_data['username']
            password = form.cleaned_data['password1']
            email = form.cleaned_data['email']
            first_name = form.cleaned_data['first_name']
            last_name = form.cleaned_data['last_name']
            user = User(username=username, email=email, first_name=first_name, last_name=last_name)
            user.set_password(password)
            user.save()
            address_one = form.cleaned_data['address_one']
            address_two = form.cleaned_data['address_two']
            city = form.cleaned_data['city']
            state = form.cleaned_data['state']
            sub = Subscriber(address_one=address_one, address_two=address_two, city=city, state=state, user_rec=user)
            sub.save()

            # authen automatically
            a_u = authenticate(username=username, password=password)
            if a_u is not None:
                if a_u.is_active:
                    login(request, a_u)
                    return HttpResponseRedirect(reverse('home'))
                else:
                    return HttpResponseRedirect(reverse('django.contrib.auth.views.login'))

            else:
                return HttpResponseRedirect(reverse('sub_new'))
    else:
        form = SubscriberForm()
    return render(request, template, {'form':form})
