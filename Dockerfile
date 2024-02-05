FROM python:3.9.5
WORKDIR /app
RUN pip install --upgrade pip
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt
# Copy the entire project directory into the container
COPY . .
ENTRYPOINT ["streamlit", "run", "--server.address", "0.0.0.0", "--server.port", "8501", "main.py"]