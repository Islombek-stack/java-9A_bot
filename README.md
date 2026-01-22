        
# Attendance Bot (Multi-module Maven)
Minimal multi-module template for the attendance Telegram-bot.
Modules:
- bot-core: Telegram bot + handlers
- service: business logic
- storage: DAO, migrations
- web-api: webhook/admin
- integrations: external integrations
- utils: shared utilities

How to build:
mvn -v
mvn -T1C clean package

To run bot (after setting BOT_USERNAME and BOT_TOKEN env vars):
cd bot-core
mvn exec:java -Dexec.mainClass="uz.islom.attendancebot.BotApp"

It's my java bot project.
The End!
