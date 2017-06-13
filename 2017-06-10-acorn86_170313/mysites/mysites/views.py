from django.shortcuts import render
from django.views.generic.base import TemplateView
from matplotlib.backends.backend_agg import FigureCanvasAgg as FigureCanvas
from django.http import HttpResponse, JsonResponse
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import matplotlib
#matplotlib.use('Agg')
# response = HttpResponse(content_type='application/force-download')


def Pandas_Graph(request):
    fig = plt.figure(figsize=(6, 4.5), dpi=80, facecolor='w', edgecolor='w')
    ax = fig.add_subplot(111)
    f = pd.DataFrame({'y':np.random.randn(10), 'z':np.random.randn(10)}, index=pd.period_range('1-2000', periods=10))
    f.plot(ax=ax)
    canvas = FigureCanvas(fig)
    response = HttpResponse(content_type='image/png')
    canvas.print_png(response)
    return response


class HomeView(TemplateView):
    template_name = 'home.html'

    def get_context_data(self, **kwargs):
        context = super(HomeView, self).get_context_data(**kwargs)
        context['object_list'] = ['polls', 'marcador']
        return context


def login_ajax(request):
	if request.method == 'POST':
		if request.is_ajax():
			email = request.POST.get('email')
			password = request.POST.get('password')
			data = {"email":email, "password":password}
			return JsonResponse(data)
	return render(request, 'login_ajax.html')
