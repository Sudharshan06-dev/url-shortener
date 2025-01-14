import { Github, Linkedin, FileText } from 'lucide-react';

export default function ShortUrlFooter() {
    return (
        <footer className="w-full bg-black/10 backdrop-blur-sm py-6">
            <div className="max-w-4xl mx-auto px-6">
                <div className="flex justify-center items-center gap-12 mb-6">
                    <a href="https://drive.google.com/file/d/1qbdlZaW0wa-LOWM6Yz3X1_JBy-rUPi7w/view?usp=sharing"
                       target="_blank"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <FileText className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>Resume</span>
                    </a>

                    <a href="https://github.com/Sudharshan06-dev"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <Github className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>GitHub</span>
                    </a>

                    <a href="https://www.linkedin.com/in/sudharshan06-dev"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 text-white/90 hover:text-white transition-all group"
                    >
                        <Linkedin className="group-hover:scale-105 transition-transform" size={20}/>
                        <span>LinkedIn</span>
                    </a>
                </div>

                <div className="text-center text-white/70 text-sm">
                    © {new Date().getFullYear()} Sudharshan Madhavan. All rights reserved.
                </div>
            </div>
        </footer>
    )
}