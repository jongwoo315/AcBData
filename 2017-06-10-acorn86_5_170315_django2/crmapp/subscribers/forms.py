#-*-encoding:utf-8-*-
from django import forms
from django.contrib.auth.forms import UserCreationForm

# upgrade forms(상속 이용)
from .models import Subscriber

# class ContactForm(forms.ModelForm):
#
# class SearchForm(forms.ModelForm):
#     search_query = forms.CharField(max_length=100)
#
# def search(request):
#     if request.method == 'POST':
#         # request.POST는 사용자가 제출한 데이터
#         form = ContactForm(request.POST)
#         # is.valid()는 form하나하나를 검사
#         if form.is_valid():
#             # cleaned_data는 양식에 맞아서 통과된 form을 의미
#             s_query = form.cleaned_data['search_query']
#             # SomeTable은 데이터베이스를 의미
#             s_results = SomeTable.objects.filter(name=s_query)
#             return render(request, 'search.html', {'form':form, 's_results':s_results})
#
#     else:
#         form = SearchForm()
#
#     return render(request, 'search.html', {'form':form,})

# upgrade forms
# forms.ModelForm을 상속받는다
# ModelForm은 model에 기반을 둔 form을 원할 때 사용한다(이 경우에는 Subscriber(models.py)에 기반을 둠)
class AddressMixin(forms.ModelForm):
    # innerclass인 Meta는, ModelForm에 기반을 둔 model에게 요구되는 것임
    class Meta:
        model = Subscriber
        # fields에 들어가는 내용은 models.py(SQL)에서 정의한 변수들 / 보여질 필드만 정의하다.
        fields = ('address_one', 'address_two', 'city', 'state',)
        # 모든 필드가 TextInput으로 설정이 되었는데 이건 HTML에서 <input>으로 render가 된다
        widgets = {
            'address_one':forms.TextInput(attrs={'class':'form-control'}),
            'address_two':forms.TextInput(attrs={'class':'form-control'}),
            'city':forms.TextInput(attrs={'class':'form-control'}),
            'state':forms.TextInput(attrs={'class':'form-control'}),
        }

class SubscriberForm(AddressMixin, UserCreationForm):
    first_name = forms.CharField(
        required=True, widget=forms.TextInput(attrs={'class':'form-control'})
    )
    last_name = forms.CharField(
        required=True, widget=forms.TextInput(attrs={'class':'form-control'})
    )
    # 'class'부분은 나중에 html에서 render가 될 때 영향을 주는 것(html class tag가 이걸로 되야 한다?)
    email = forms.EmailField(
        required=True, widget=forms.TextInput(attrs={'class':'form-control'})
    )
    username = forms.CharField(
        widget=forms.TextInput(attrs={'class':'form-control'})
    )
    password1 = forms.CharField(
        widget=forms.TextInput(attrs={'class':'form-control', 'type':'password'})
    )
    password2 = forms.CharField(
        widget=forms.TextInput(attrs={'class':'form-control', 'type':'password'})
    )
