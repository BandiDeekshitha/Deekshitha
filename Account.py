# import streamlit as st
# import firebase_admin
# from firebase_admin import firestore
# from firebase_admin import credentials
# from firebase_admin import auth


# cred = credentials.Certificate("stockpulse-b1818-afca9e4f09d8.json")
# firebase_admin.initialize_app(cred)


# def app():
    
#     st.title('Welcome to :violet[StockPulse] :sunglasses:')

    
#     if 'username' not in st.session_state:
#         st.session_state.username=''
#     if 'useremail' not in st.session_state:
#         st.session_state.useremail=''
        
#     def f():
#         try:
#             user = auth.get_user_by_email(email)
#             print(user.uid)
#             st.write('Login success')
#             st.session_state.username=user.uid
#             st.session_state.useremail=user.email
#             st.session_state.signedout = True
#             st.session_state.signout = True
            

#         except:
#             st.warning('Login Failed')
            
#     def t():
#         st.session_state.signout=False
#         st.session_state.signedout=False
#         st.session_state.username = ''
    
#     if 'signedout' not in st.session_state:
#         st.session_state.signedout=False
#     if 'signout' not in st.session_state:
#         st.session_state.signout=False
    
#     if not st.session_state['signedout']:
#         choice=st.selectbox('Login/Signup', ['Login','Sign'])

        
    
#         if choice=='Login':
            
#             email=st.text_input('Email')
#             password = st.text_input('Password',type='password')
            
#             st.button('Login', on_click=f)
        
#         else:
            
#             email=st.text_input('Email')
#             password = st.text_input('Password',type='password')
            
#             username = st.text_input('Enter Unique username')
            
#             if st.button('Create account'):
#                 user = auth.create_user(email=email, password=password, uid=username)
#                 st.success('Account created')
#                 st.markdown('Please login using username and password')
#                 st.balloons()
    
    
#     if st.session_state.signout:
#         st.text('Name'+st.session_state.username)
#         st.text('Email id: '+st.session_state.useremail) 
#         st.button('Sign out', on_click=t)       
                    
        

                                


import streamlit as st
import firebase_admin
from firebase_admin import firestore
from firebase_admin import credentials
from firebase_admin import auth
 
 
cred = credentials.Certificate("stockpulse-9127a-455d809b3467.json")
firebase_admin.initialize_app(cred)
 
 
def app():
   
    st.title('Welcome to :violet[StockPulse] :')
 
   
    if 'username' not in st.session_state:
        st.session_state.username=''
    if 'useremail' not in st.session_state:
        st.session_state.useremail=''
        
        
        
        

    
    def f():
        try:
            
            user = auth.get_user_by_email(email)
            # user = auth.sign_in_with_email_and_password(email, password)
            print(user.uid)
            # print(user.password)
            st.write('Login success')
            st.session_state.username=user.uid
            st.session_state.useremail=user.email
            st.session_state.signedout = True
            st.session_state.signout = True
 
        except:
            st.warning('Login Failed')
           
    def t():
        st.session_state.signout=False
        st.session_state.signedout=False
        st.session_state.username = ''
   
    if 'signedout' not in st.session_state:
        st.session_state.signedout=False
    if 'signout' not in st.session_state:
        st.session_state.signout=False
   
    if not st.session_state['signedout']:
        choice=st.selectbox('Login/Signup', ['Login','Sign'])
 
       
   
        if choice=='Login':
           
            email=st.text_input('Email')
            password = st.text_input('Password',type='password')
            # password = st.text_input('Password')

            st.button('Login', on_click=f)
       
        else:
            try:
                email=st.text_input('Email')
                password = st.text_input('Password',type="password")
                # password = st.text_input('Password')
            
                username = st.text_input('Enter Unique username')
            
                if st.button('Create account'):
                    user = auth.create_user(email=email, password=password, uid=username)
                    st.success('✅ Account created successfully!')
                    st.markdown('Please login using username and password')
            except:
                st.write("Invalid Email or Password")
            
    if st.session_state.signout:
        st.text('Name'+st.session_state.username)
        st.text('Email id: '+st.session_state.useremail)
        st.button('Sign out', on_click=t)      
