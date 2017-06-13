#-*-encoding:utf-8-*-
import sys

from django.conf import settings
#from django.conf.urls import patterns
from django.http import HttpResponse
from django.conf.urls import url

# # run the development web server from the command line
from django.core.management import execute_from_command_line

settings.configure(
    # render helpful error pages in your browser
    DEBUG = True,
    # used to provide cryptographic signing
    SECRET_KEY = 'thisisabadkeybutitwilldo',
    # says the URL configurations will be in this file
    ROOT_URLCONF = sys.modules[__name__],
)

def index(request):
    return HttpResponse('Hello, World')

# hello-world는 url주소 // index는 view(파이썬 파일, 혹은 함수)
# hello-world로 접속하면 index(파일 or 함수)가 실행됨
urlpatterns = [url(r'^hello-world/$', index),]

# tell our application that
# if this file is the main script file,
# it should use the execute_from_command_line utility.
if __name__ == "__main__":
    execute_from_command_line(sys.argv)
