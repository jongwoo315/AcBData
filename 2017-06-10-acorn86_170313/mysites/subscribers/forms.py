from django import forms
from django.contrib.auth.forms import UserCreationForm
from .models import Subscriber
# from django.forms import ModelForm
# from customer.models import Customer

class AddressMixin(forms.ModelForm):
    class Meta:
        model = Subscriber
        fields = ('address_one', 'address_two', 'city', 'state',)
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
    # def clean(self):
    #     password1 = self.clean_password()
    #     password2 = self.cleaned_data['password2']
    #     if password1 and password2 and password1 == password2:
    #     return self.cleaned_data
    #     else:
    #     raise forms.ValidationError('The passwords did not match, Please try again.')
    #
    # def clean_password(self):
    #     if self.password and self.cleaned_data['password']:
    #         return self.cleaned_data['password']
    #     else:
    #         raise forms.ValidationError("Enter a password.")
    #
    # def clean_password1(self):
    #     if not self.cleaned_data['password1']:
    #         raise forms.ValidationError("Enter your password (again)")
