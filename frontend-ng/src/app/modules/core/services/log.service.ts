import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  level: LogLevel = LogLevel.WARN;

  constructor() {
  }

  error(message) {
    this.log(LogLevel.ERROR, message);
  }

  warn(message) {
    this.log(LogLevel.WARN, message);
  }

  info(message) {
    this.log(LogLevel.INFO, message);
  }

  debug(message) {
    this.log(LogLevel.DEBUG, message);
  }

  private log(level: LogLevel, message: string) {
    if (this.shouldLog(level)) {
      console.log(`${new Date()}: [${level}] ${message}`);
    }
  }

  private shouldLog(level: LogLevel): boolean {
    return level <= this.level;
  }
}

export enum  LogLevel {
  OFF   = 0,
  ERROR = 1,
  WARN  = 2,
  INFO  = 3,
  DEBUG = 4
}
