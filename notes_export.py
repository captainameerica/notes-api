import requests
import csv

response = requests.get("http://localhost:8080/notes")
notes = response.json()

with open("notes_summary.csv", "w", newline="") as f:
    writer = csv.DictWriter(f, fieldnames=["id", "title", "content"])
    writer.writeheader()
    writer.writerows(notes)

print(f"Exported {len(notes)} notes to notes_summary.csv")