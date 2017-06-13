#-*-encoding:utf-8-*-
from django.shortcuts import render  # html파일과 form의 내용을 받아 web으로 쏴준다
from django.contrib.auth.models import User
from django.http import HttpResponseRedirect
from .forms import SubscriberForm
# models에는 sql저장에 대한 정의를 내린다.
from .models import Subscriber  # 같은 폴더 내의 models에서 import하는 것이므로 models앞에 .을 찍는다
from django.core.urlresolvers import reverse


def subscriber_new(request, template='subscribers/subscriber_new.html'):
    if request.method == 'POST':
        # request.POST는 사용자가 제출한 데이터
        form = SubscriberForm(request.POST)
        # is.valid()는 form하나하나를 검사(모든 form은 is_valid메서드를 가진다)
        if form.is_valid():
            # cleaned_data는 양식에 맞아서 통과된 forms를 의미
            username = form.cleaned_data['username']
            password = form.cleaned_data['password1']
            email = form.cleaned_data['email']

            first_name = form.cleaned_data['first_name']
            last_name = form.cleaned_data['last_name']

            # create the user record
            user = User(username=username, email=email, first_name=first_name, last_name=last_name)
            user.set_password(password)
            # 데이터베이스에 데이터가 저장되는 시점(유저명과 이메일만 저장됨)
            # 데이터베이스 테이블명 auth_user
            user.save()

            # create subscriber record
            # user_rec은 외래키역할 / models.py에 선언한 변수들만 있음
            address_one = form.cleaned_data['address_one']
            address_two = form.cleaned_data['address_two']
            city = form.cleaned_data['city']
            state = form.cleaned_data['state']
            sub = Subscriber(address_one=address_one, address_two=address_two, city=city, state=state, user_rec=user)
            # 데이터베이스 테이블 명 subscribers_subscriber
            sub.save()

            # 위의 모든 과정이 끝나면 사용자를 /success 페이지로 이동시킨다.
            # return HttpResponseRedirect('/success/')
            # reverse는 crmapp의 url의 최상단에서 name을 찾아간다
            # 없으면
            return HttpResponseRedirect(reverse('home'))
    # This code is executed if the user is requesting the subscription form for the first time.
    # If that's the case, this code kicks in and will create an instance of the SubscriberForm.
    # This instance can then be displayed in the template.
    else:  # request방식이 GET일 때
        form = SubscriberForm()
    # template은 내용을 입력한 양식html
    # This uses the render shortcut to return the request, template, and form to the user.
    # This marks the end of the view processing
    # and is what provides the blank form to the end user.
    return render(request, template, {'form':form})
