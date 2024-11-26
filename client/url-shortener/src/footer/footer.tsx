import { Github, Linkedin, FileText } from 'lucide-react';

export default function ShortUrlFooter() {
    return (
        <footer className="w-full bg-black/10 backdrop-blur-sm py-6">
            <div className="max-w-4xl mx-auto px-6">
                <div className="flex justify-center items-center gap-12 mb-6">
                    <a
                        href="/resume"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <FileText className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>Resume</span>
                    </a>

                    <a
                        href="https://github.com/yourusername"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <Github className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>GitHub</span>
                    </a>

                    <a
                        href="https://linkedin.com/in/yourusername"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <Linkedin className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>LinkedIn</span>
                    </a>
                </div>

                <div className="text-center text-white/70 text-sm">
                    © {new Date().getFullYear()} Your Name. All rights reserved.
                </div>
            </div>
        </footer>
    )
}