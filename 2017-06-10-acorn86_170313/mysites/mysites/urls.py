"""mysites URL Configuration

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
#from views import Pandas_Graph
from mysites import views
from polls import views as vw
from django.conf.urls import include
from polls import urls as pv
from django.contrib.auth.views import login, logout
from django.core.urlresolvers import reverse_lazy
from marcador import urls as mar
from subscribers import views as subvw
#from myapp import views as myappviews
from myapp import views as myvw
admin.autodiscover()
from django.conf import settings
from django.conf.urls.static import static
from django.core.urlresolvers import reverse
import sungjuk.urls
urlpatterns = [
    url(r'^admin/', admin.site.urls),
    #url(r'^pandas_graph/', Pandas_Graph, name='pandas_graph'),
    url(r'^pandas_graph/', views.Pandas_Graph, name='pandas_graph'),
    #url(r'^poll/', vw.IndexView, name='pollindex'),
    #url(r'^polls/', include('polls.urls', namespace="polls")),
    url(r'^polls/', include(pv.urlpatterns, namespace="polls")),
    url(r'^$', views.HomeView.as_view(), name='home'),
    #url(r'^$', vw.HomeView, name='home'),
    #url(r'^marcador/', include('marcador.urls', namespace="marcador")),
    url(r'^marcador/', include(mar.urlpatterns, namespace="marcador")),
    # url(r'^login/$', 'django.contrib.auth.views.login', {'template_name':'login.html'}, name='mysites_login'),
    # url(r'^logout/$', 'django.contrib.auth.views.logout', {'next_page':reverse_lazy('home')}, name='mysites_logout'),
    # url(r'^login/$', login, {'template_name':'login.html'}, name='mysites_login'),
    # url(r'^logout/$', logout, {'next_page':reverse_lazy('home')}, name='mysites_logout'),
    url(r'^login/$', login, name='mysites_login'),
    url(r'^logout/$', logout, name='mysites_logout'),
    url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    url(r'^login_ajax/$', views.login_ajax, name='loginajax'),
    url(r'^signup/$', subvw.subscriber_new, name='new_subscriber'),
    url(r'^list/$', myvw.list, name='list'),
    url(r'^sungjuk/', include(sungjuk.urls.urlpatterns, namespace="sungjuk")),
    #url(r'^list/$', include(myvw.list, namespace='list')),
] + static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)
